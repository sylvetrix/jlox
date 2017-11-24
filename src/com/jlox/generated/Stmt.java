package com.jlox.generated;

import com.jlox.Token;
import java.util.List;

public abstract class Stmt
{
	public interface Visitor<R>
	{
		R visitBlockStmt(Block stmt);
		R visitClassStmt(Class stmt);
		R visitExpressionStmt(Expression stmt);
		R visitFunctionStmt(Function stmt);
		R visitIfStmt(If stmt);
		R visitPrintStmt(Print stmt);
		R visitReturnStmt(Return stmt);
		R visitVarStmt(Var stmt);
		R visitWhileStmt(While stmt);
	}

	public static class Block extends Stmt
	{
		public final List<Stmt> statements;

		public Block(List<Stmt> statements)
		{
			this.statements = statements;
		}

		public <R> R accept(Visitor<R> visitor)
		{
			return visitor.visitBlockStmt(this);
		}
	}

	public static class Class extends Stmt
	{
		public final Token name;
		public final List<Stmt.Function> methods;

		public Class(Token name, List<Stmt.Function> methods)
		{
			this.name = name;
			this.methods = methods;
		}

		public <R> R accept(Visitor<R> visitor)
		{
			return visitor.visitClassStmt(this);
		}
	}

	public static class Expression extends Stmt
	{
		public final Expr expression;

		public Expression(Expr expression)
		{
			this.expression = expression;
		}

		public <R> R accept(Visitor<R> visitor)
		{
			return visitor.visitExpressionStmt(this);
		}
	}

	public static class Function extends Stmt
	{
		public final Token name;
		public final List<Token> parameters;
		public final List<Stmt> body;

		public Function(Token name, List<Token> parameters, List<Stmt> body)
		{
			this.name = name;
			this.parameters = parameters;
			this.body = body;
		}

		public <R> R accept(Visitor<R> visitor)
		{
			return visitor.visitFunctionStmt(this);
		}
	}

	public static class If extends Stmt
	{
		public final Expr condition;
		public final Stmt thenBranch;
		public final Stmt elseBranch;

		public If(Expr condition, Stmt thenBranch, Stmt elseBranch)
		{
			this.condition = condition;
			this.thenBranch = thenBranch;
			this.elseBranch = elseBranch;
		}

		public <R> R accept(Visitor<R> visitor)
		{
			return visitor.visitIfStmt(this);
		}
	}

	public static class Print extends Stmt
	{
		public final Expr expression;

		public Print(Expr expression)
		{
			this.expression = expression;
		}

		public <R> R accept(Visitor<R> visitor)
		{
			return visitor.visitPrintStmt(this);
		}
	}

	public static class Return extends Stmt
	{
		public final Token keyword;
		public final Expr value;

		public Return(Token keyword, Expr value)
		{
			this.keyword = keyword;
			this.value = value;
		}

		public <R> R accept(Visitor<R> visitor)
		{
			return visitor.visitReturnStmt(this);
		}
	}

	public static class Var extends Stmt
	{
		public final Token name;
		public final Expr initializer;

		public Var(Token name, Expr initializer)
		{
			this.name = name;
			this.initializer = initializer;
		}

		public <R> R accept(Visitor<R> visitor)
		{
			return visitor.visitVarStmt(this);
		}
	}

	public static class While extends Stmt
	{
		public final Expr condition;
		public final Stmt body;

		public While(Expr condition, Stmt body)
		{
			this.condition = condition;
			this.body = body;
		}

		public <R> R accept(Visitor<R> visitor)
		{
			return visitor.visitWhileStmt(this);
		}
	}

	public abstract <R> R accept(Visitor<R> visitor);
}
