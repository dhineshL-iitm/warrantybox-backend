const http = new EasyHTTP()
const url = window.location.origin + '/api/v1/brand/gettickets'

const dashboard = http
  .get(url)
  .then((data) => {
    console.log(data)
    for (let index = 0; index < data.length; index++) {
      const element = data[index]
      console.log(element)
      let ticketform = `<span id="ticket-event"
        ><input
          type="submit"
          class="btn-danger submit-ticket"
          id="${element.invoiceNo}"
          value="Resolve Ticket"
      /></span>`
      const productentry = `<tr>
        <td>${element.invoiceNo}</td>
        <td>${element.brand}</td>
        <td>${element.model}</td>
        <td>${element.warranty}</td>
        <td>${element.seller}</td>
        <td>${element.status}</td>
        <td>${element.username}</td>
        <td>
        ${ticketform}
      </td>
      </tr>`
      document.getElementById('product-table').innerHTML += productentry
    }
  })
  .catch((err) => console.log(error))

const liketvshow = dashboard.then((data) => {
  document.getElementById('ticket-event').addEventListener('click', (e) => {
    if (e.target.classList.contains('submit-ticket')) {
      console.log(e.target.id)

      const ticketdata = {}

      console.log(ticketdata)
      const resolveurl = window.location.origin + '/api/v1/brand/resolveticket'

      var url2 = new URL(resolveurl)

      url2.searchParams.append('invoiceNo', e.target.id)

      http
        .put(url2, ticketdata)
        .then(() => {
          alert('request raised')
          window.location.reload()
        })
        .catch((err) => console.log(err))
    }
  })
})
