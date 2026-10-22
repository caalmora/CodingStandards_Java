<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
 xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <xsl:output method="html" encoding="UTF-8" indent="yes"/>
 <xsl:template match="/">
  <html>
   <head>
    <meta charset="UTF-8"/>
    <title>Informe Checkstyle - Java</title>
   </head>
   <body>
    <h1>Informe de estándares de código Java</h1>
    <p>Repositorio: CodingStandards_Java</p>
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
       <td><xsl:value-of select="../../@name"/></td>
       <td><xsl:value-of select="@line"/></td>
       <td><xsl:value-of select="@column"/></td>
       <td><xsl:value-of select="@severity"/></td>
       <td><xsl:value-of select="@message"/></td>
      </tr>
     </xsl:for-each>
    </table>
    <p>El informe contiene los incumplimientos detectados por Checkstyle.</p>
   </body>
  </html>
 </xsl:template>
</xsl:stylesheet>
