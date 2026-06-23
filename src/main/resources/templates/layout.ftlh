<#macro layout>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Document</title>
</head>
<body>
    <header>
        Events
    </header>
    <hr>
    <main>
        <#nested>
    </main>
    <hr>
    <footer>
        <a href="#">Imprint</a>
        <a href="#">About us</a>
    </footer>
</body>
</html>
</#macro>