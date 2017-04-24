package com.jlox.generated;

import com.jlox.Token;
import java.util.List;

public abstract class Expr
{
	public static class Binary extends Expr
	{
		final Expr left;
		final Token operator;
		final Expr right;

		Binary(Expr left, Token operator, Expr right)
		{
			this.left = left;
			this.operator = operator;
			this.right = right;
		}
	}

	public static class Grouping extends Expr
	{
		final Expr expression;

		Grouping(Expr expression)
		{
			this.expression = expression;
		}
	}

	public static class Literal extends Expr
	{
		final Object value;

		Literal(Object value)
		{
			this.value = value;
		}
	}

	public static class Unary extends Expr
	{
		final Token operator;
		final Expr right;

		Unary(Token operator, Expr right)
		{
			this.operator = operator;
			this.right = right;
		}
	}
}
