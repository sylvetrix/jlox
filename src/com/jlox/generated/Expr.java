package com.jlox.generated;

import com.jlox.Token;
import java.util.List;

public abstract class Expr
{
	public interface Visitor<R>
	{
		R visitBinaryExpr(Binary expr);
		R visitGroupingExpr(Grouping expr);
		R visitLiteralExpr(Literal expr);
		R visitUnaryExpr(Unary expr);
		R visitVariableExpr(Variable expr);
	}

	public static class Binary extends Expr
	{
		public final Expr left;
		public final Token operator;
		public final Expr right;

		public Binary(Expr left, Token operator, Expr right)
		{
			this.left = left;
			this.operator = operator;
			this.right = right;
		}

		public <R> R accept(Visitor<R> visitor)
		{
			return visitor.visitBinaryExpr(this);
		}
	}

	public static class Grouping extends Expr
	{
		public final Expr expression;

		public Grouping(Expr expression)
		{
			this.expression = expression;
		}

		public <R> R accept(Visitor<R> visitor)
		{
			return visitor.visitGroupingExpr(this);
		}
	}

	public static class Literal extends Expr
	{
		public final Object value;

		public Literal(Object value)
		{
			this.value = value;
		}

		public <R> R accept(Visitor<R> visitor)
		{
			return visitor.visitLiteralExpr(this);
		}
	}

	public static class Unary extends Expr
	{
		public final Token operator;
		public final Expr right;

		public Unary(Token operator, Expr right)
		{
			this.operator = operator;
			this.right = right;
		}

		public <R> R accept(Visitor<R> visitor)
		{
			return visitor.visitUnaryExpr(this);
		}
	}

	public static class Variable extends Expr
	{
		public final Token name;

		public Variable(Token name)
		{
			this.name = name;
		}

		public <R> R accept(Visitor<R> visitor)
		{
			return visitor.visitVariableExpr(this);
		}
	}

	public abstract <R> R accept(Visitor<R> visitor);
}
