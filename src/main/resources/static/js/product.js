const http = new EasyHTTP()
const url = window.location.origin + '/api/v1/brand/getserialno'

const dashboard = http
  .get(url)
  .then((data) => {
    console.log(data)
    for (let index = 0; index < data.length; index++) {
      const element = data[index]
      console.log(element)
      const productentry = `<tr>
        <td>${element.serialNo}</td>
        <td>${element.localDate}</td>
        <td>${element.model}</td>
        <td>${element.warranty}</td>
      </tr>`
      document.getElementById('product-table').innerHTML += productentry
    }
  })
  .catch((err) => console.log(err))

const liketvshow = dashboard.then((data) => {
  document.getElementById('product-table').addEventListener('click', (e) => {
    if (e.target.classList.contains('submit-ticket')) {
      console.log(e.target.id)
      console.log(data)

      prev = e.target
      do prev = prev.previousSibling
      while (prev && prev.nodeType !== 1)

      console.log(prev.value)

      const ticketdata = {}

      console.log(ticketdata)
      const url = window.location.origin + '/api/v1/user/raiseticket'

      var url2 = new URL(url)

      url2.searchParams.append('invoiceNo', e.target.id)
      url2.searchParams.append('issue', prev.value)

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
