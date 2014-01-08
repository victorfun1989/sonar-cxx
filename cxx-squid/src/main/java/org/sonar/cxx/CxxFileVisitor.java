/*
 * Sonar C++ Plugin (Community)
 * Copyright (C) 2011 Waleri Enns and CONTACT Software GmbH
 * dev@sonar.codehaus.org
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
package org.sonar.cxx;

import com.sonar.sslr.api.AstAndTokenVisitor;
import com.sonar.sslr.api.AstNode;
import com.sonar.sslr.api.Grammar;
import com.sonar.sslr.api.Token;
import com.sonar.sslr.squid.SquidAstVisitor;
import org.sonar.squid.measures.MetricDef;
import com.sonar.sslr.squid.SquidAstVisitorContext;

import org.sonar.cxx.parser.CxxParser;

public class CxxFileVisitor<GRAMMAR extends Grammar> extends SquidAstVisitor<GRAMMAR>
  implements AstAndTokenVisitor {

  private SquidAstVisitorContext context = null;
  
  CxxFileVisitor(SquidAstVisitorContext context){
    this.context = context;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public void visitFile(AstNode node) {
    CxxParser.finishedParsing(context.getFile());
  }

  /**
   * {@inheritDoc}
   */
  public void visitToken(Token token) {
  }
}

