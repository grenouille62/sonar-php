/*
 * SonarQube PHP Plugin
 * Copyright (C) 2010 SonarSource and Akram Ben Aissi
 * sonarqube@googlegroups.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.php.tree.impl.statement;

import org.junit.Test;
import org.sonar.php.PHPTreeModelTest;
import org.sonar.php.parser.PHPLexicalGrammar;
import org.sonar.plugins.php.api.tree.Tree.Kind;
import org.sonar.plugins.php.api.tree.statement.BlockTree;

import static org.fest.assertions.Assertions.assertThat;

public class BlockTreeTest extends PHPTreeModelTest {

  @Test
  public void empty() throws Exception {
    BlockTree tree = parse("{}", PHPLexicalGrammar.BLOCK);

    assertThat(tree.is(Kind.BLOCK)).isTrue();
    assertThat(tree.statements()).isEmpty();
  }

  @Test
  public void not_empty() throws Exception {
    BlockTree tree = parse("{ $a; }", PHPLexicalGrammar.BLOCK);
    assertThat(tree.statements()).hasSize(1);

    tree = parse("{ $a; $b; }", PHPLexicalGrammar.BLOCK);
    assertThat(tree.statements()).hasSize(2);
  }

}
