<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" encoding="UTF-8" indent="yes"/>

<xsl:template match="/">
<html>
<head>
<meta charset="UTF-8"/>
<title>Informe Checkstyle Java</title>
</head>
<body>
<h1>Informe de estándares de código Java</h1>
<p>Repositorio: CodingStandards_Java</p>
<p>Archivo analizado: src/Main.java</p>

<h2>Resumen de auditoría</h2>
<p>Incumplimientos encontrados: <xsl:value-of select="count(//error)"/></p>

<xsl:choose>
<xsl:when test="count(//error) = 0">
<h3>Resultado: Sin incumplimientos detectados</h3>
<p>El archivo cumple con las reglas configuradas en Checkstyle.</p>
</xsl:when>
<xsl:otherwise>
<h3>Resultado: Se encontraron incumplimientos</h3>
</xsl:otherwise>
</xsl:choose>

<h2>Detalle de incumplimientos</h2>
<table border="1" cellpadding="6">
<tr>
<th>Archivo</th>
<th>Línea</th>
<th>Columna</th>
<th>Severidad</th>
<th>Descripción</th>
</tr>
<xsl:for-each select="//error">
<tr>
<td><xsl:value-of select="../@name"/></td>
<td><xsl:value-of select="@line"/></td>
<td><xsl:value-of select="@column"/></td>
<td><xsl:value-of select="@severity"/></td>
<td><xsl:value-of select="@message"/></td>
</tr>
</xsl:for-each>
</table>

<p>Herramienta utilizada: Checkstyle</p>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
