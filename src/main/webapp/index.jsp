
<!DOCTYPE html>
<head>
    <title>Notepads</title>
</head>
<body>
<h2>All Notebooks</h2>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Brand</th>
        <th>Name</th>
        <th>Page Amount</th>
        <th>Cover</th>
        <th>Country</th>
        <th>Page Type</th>
    </tr>
    <c:forEach var="notebook" items="${notebooks}">
        <tr>
            <td>${notebook.id}</td>
            <td>${notebook.brand}</td>
            <td>${notebook.name}</td>
            <td>${notebook.pageAmount}</td>
            <td>${notebook.cover}</td>
            <td>${notebook.country}</td>
            <td>${notebook.pageType}</td>
        </tr>
    </c:forEach>
</table>

<h2>All Countries</h2>
<c:forEach var="country" items="${countries}">
    <p>${country}</p>
</c:forEach>

<h2>Country Notebook Counts</h2>
<c:forEach var="countryCount" items="${countryNotebookCounts}">
    <p>${countryCount}</p>
</c:forEach>

<h2>Country With Most Notebooks</h2>
<p>${countryWithMostNotebooks}</p>

<h2>Country With The Least Notebooks</h2>
<p>${countryWithLeastNotebooks}</p>

<h2>Brand With Most Notebooks</h2>
<p>${brandWithMostNotebooks}</p>

<h2>Brand With The Least Notebooks</h2>
<p>${brandWithLeastNotebooks}</p>

<h2>Hard Cover Notebooks</h2>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Brand</th>
        <th>Name</th>
        <th>Page Amount</th>
        <th>Cover</th>
        <th>Country</th>
        <th>Page Type</th>
    </tr>
    <c:forEach var="notebook" items="${hardCoverNotebooks}">
        <tr>
            <td>${notebook.id}</td>
            <td>${notebook.brand}</td>
            <td>${notebook.name}</td>
            <td>${notebook.pageAmount}</td>
            <td>${notebook.cover}</td>
            <td>${notebook.country}</td>
            <td>${notebook.pageType}</td>
        </tr>
    </c:forEach>
</table>

<h2>Soft Cover Notebooks</h2>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Brand</th>
        <th>Name</th>
        <th>Page Amount</th>
        <th>Cover</th>
        <th>Country</th>
        <th>Page Type</th>
    </tr>
    <c:forEach var="notebook" items="${softCoverNotebooks}">
        <tr>
            <td>${notebook.id}</td>
            <td>${notebook.brand}</td>
            <td>${notebook.name}</td>
            <td>${notebook.pageAmount}</td>
            <td>${notebook.cover}</td>
            <td>${notebook.country}</td>
            <td>${notebook.pageType}</td>
        </tr>
    </c:forEach>
</table>
</body>
