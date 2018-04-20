package com.jlox;

import java.util.HashMap;
import java.util.Map;

class LoxInstance
{
	private LoxClass lClass;
	private final Map<String, Object> fields = new HashMap<>();

	LoxInstance(LoxClass lClass)
	{
		this.lClass = lClass;
	}

	Object get(Token name)
	{
		if (fields.containsKey(name.lexeme))
		{
			return fields.get(name.lexeme);
		}

		LoxFunction method = lClass.findMethod(this, name.lexeme);
		if (method != null)
		{
			return method;
		}

		throw new RuntimeError(name, "Undefined property '" + name.lexeme + "'.");
	}

	void set(Token name, Object value)
	{
		fields.put(name.lexeme, value);
	}

	@Override
	public String toString()
	{
		return lClass.name + " instance";
	}
}

