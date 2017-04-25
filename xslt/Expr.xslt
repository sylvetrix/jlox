<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text"/>

	<xsl:template match="/subclasses">
		<xsl:text>package com.jlox.generated;&#10;&#10;import com.jlox.Token;&#10;import java.util.List;&#10;&#10;public abstract class Expr&#10;{&#10;&#9;public interface Visitor&#60;R&#62;&#10;&#9;{&#10;</xsl:text>
		<xsl:apply-templates select="subclass" mode="generateVisitorFunction"/>
		<xsl:text>&#9;}&#10;</xsl:text>
		<xsl:apply-templates select="subclass" mode="generateSubclass"/>
		<xsl:text>&#10;&#9;public abstract &#60;R&#62; R accept(Visitor&#60;R&#62; visitor);&#10;}&#10;</xsl:text>
	</xsl:template>

	<xsl:template match="subclass" mode="generateVisitorFunction">
		<xsl:text>&#9;&#9;R visit</xsl:text>
		<xsl:value-of select="@class"/>
		<xsl:text>Expr(</xsl:text>
		<xsl:value-of select="@class"/>
		<xsl:text> expr);&#10;</xsl:text>
	</xsl:template>

	<xsl:template match="subclass" mode="generateSubclass">
		<xsl:text>&#10;&#9;public static class </xsl:text>
		<xsl:value-of select="@class"/>
		<xsl:text> extends Expr&#10;&#9;{&#10;</xsl:text>
		<xsl:apply-templates select="property" mode="generateField"/>
		<xsl:text>&#10;&#9;&#9;public </xsl:text>
		<xsl:value-of select="@class"/>
		<xsl:text>(</xsl:text>
		<xsl:apply-templates select="property" mode="generateConstructorParam"/>
		<xsl:text>)&#10;&#9;&#9;{&#10;</xsl:text>
		<xsl:apply-templates select="property" mode="generateAssignment"/>
		<xsl:text>&#9;&#9;}&#10;&#10;&#9;&#9;public &#60;R&#62; R accept(Visitor&#60;R&#62; visitor)&#10;&#9;&#9;{&#10;&#9;&#9;&#9;return visitor.visit</xsl:text>
		<xsl:value-of select="@class"/>
		<xsl:text>Expr(this);&#10;&#9;&#9;}&#10;&#9;}&#10;</xsl:text>
	</xsl:template>
	
	<xsl:template match="property" mode="generateAssignment">
		<xsl:text>&#9;&#9;&#9;this.</xsl:text>
		<xsl:value-of select="@name"/>
		<xsl:text> = </xsl:text>
		<xsl:value-of select="@name"/>
		<xsl:text>;&#10;</xsl:text>
	</xsl:template>

	<xsl:template match="property" mode="generateField">
		<xsl:text>&#9;&#9;public final </xsl:text>
		<xsl:value-of select="@type"/>
		<xsl:text> </xsl:text>
		<xsl:value-of select="@name"/>
		<xsl:text>;&#10;</xsl:text>
	</xsl:template>

	<xsl:template match="property" mode="generateConstructorParam">
		<xsl:value-of select="@type"/>
		<xsl:text> </xsl:text>
		<xsl:value-of select="@name"/>
		<xsl:if test="position() != last()">, </xsl:if>
	</xsl:template>

</xsl:stylesheet>

