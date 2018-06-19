declare namespace r= "http://www.brics.dk/ixwt/recipes";
for $x in doc("@xmlDocPath")//r:ingredient
where $x/@name = 'butter'
return data($x/@amount)