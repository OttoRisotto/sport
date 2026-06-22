<#import "../layout.ftlh" as base>
<@base.layout>
    <ul>
        <#list events as event>

        </#list>
    </ul>
    <form action="/events" method ="post">
        <input placeholder="Name des Events" name="name">
        <button>Create user</button>
    </form>
</@base.layout>