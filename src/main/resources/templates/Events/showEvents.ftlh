<#import "../layout.ftlh" as base> <#-- Alias base für ../layout.ftlh -->
<@base.layout> <#-- layout hier: Name des Makros in base -->
    <ul>
        <#list events as event>
            <li><a href="/events/${event.id}">${event.name}</a></li>
        </#list>
    </ul>
    <form action="/events" method ="post">
        <input placeholder="Name des Events" name="name">
        <button>Create Event</button>
    </form>
</@base.layout>