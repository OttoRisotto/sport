<#import "../layout.ftlh" as base>
<@base.layout>
    <form action="/events/${event.id}" method=post>
        <label>Name</label>
        <input type="text" name="name" value="${event.name}">
    </form>
    </li>
        <ul>
            <li>ID: ${event.id}</li>
            <li>created at: ${event.createdAt}</li>
        </ul>
    <form action="/events/${event.id}" method="post">
        <button>Delete</button>
        <input type="hidden" name="_method" value="DELETE"/>
    </form>
    <br>
    <a href="/">Back</a>
</@base.layout>
