<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text"/>

	<xsl:template match="/subclasses">
		<xsl:text>package com.jlox.generated;&#10;&#10;import com.jlox.Token;&#10;import java.util.List;&#10;&#10;public abstract class Expr&#10;{&#10;</xsl:text>
		<xsl:apply-templates select="subclass" mode="generateSubclass"/>
		<xsl:text>}&#10;</xsl:text>
	</xsl:template>

	<xsl:template match="subclass" mode="generateSubclass">
		<xsl:text>&#x9;public static class </xsl:text>
		<xsl:value-of select="@class"/>
		<xsl:text> extends Expr&#10;&#x9;{&#10;</xsl:text>
		<xsl:apply-templates select="property" mode="generateField"/>
		<xsl:text>&#10;&#x9;&#x9;</xsl:text>
		<xsl:value-of select="@class"/>
		<xsl:text>(</xsl:text>
		<xsl:apply-templates select="property" mode="generateConstructorParam"/>
		<xsl:text>)&#10;&#x9;&#x9;{&#10;</xsl:text>
		<xsl:apply-templates select="property" mode="generateAssignment"/>
		<xsl:text>&#x9;&#x9;}&#10;&#x9;}&#10;</xsl:text>
		<xsl:if test="position() != last()">
			<xsl:text>&#10;</xsl:text>
		</xsl:if>
	</xsl:template>
	
	<xsl:template match="property" mode="generateAssignment">
		<xsl:text>&#x9;&#x9;&#x9;this.</xsl:text>
		<xsl:value-of select="@name"/>
		<xsl:text> = </xsl:text>
		<xsl:value-of select="@name"/>
		<xsl:text>;&#10;</xsl:text>
	</xsl:template>

	<xsl:template match="property" mode="generateField">
		<xsl:text>&#x9;&#x9;final </xsl:text>
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

