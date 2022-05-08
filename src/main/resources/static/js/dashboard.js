const http = new EasyHTTP()
const url = window.location.origin + '/api/v1/user/getproducts'

const dashboard = http
  .get(url)
  .then((data) => {
    console.log(data)
    for (let index = 0; index < data.length; index++) {
      const element = data[index]
      console.log(element)
      let ticketform
      if (element.status == 'TICKET') {
        ticketform = ``
      } else {
        ticketform = `<span 
        ><input type="text" id="issue" name="issue" />
        <input
          type="submit"
          class="btn-danger submit-ticket"
          id="${element.invoiceNo}"
          value="Raise Request"
      /></span>`
      }
      const productentry = `<tr>
        <td>${element.invoiceNo}</td>
        <td>${element.brand}</td>
        <td>${element.model}</td>
        <td>${element.warranty}</td>
        <td>${element.seller}</td>
        <td>${element.status}</td>
        <td>
        ${ticketform}
      </td>
      </tr>`
      document.getElementById('product-table').innerHTML += productentry
    }
  })
  .catch((err) => console.log(error))

document
  .getElementById('addproduct-form')
  .addEventListener('submit', function (e) {
    e.preventDefault()
    console.log(e)
    const invoiceNoValue = document.getElementById('invoiceNo').value
    console.log(invoiceNoValue)

    data = {
      invoiceNo: invoiceNoValue,
    }

    const url2 = window.location.origin + '/api/v1/user/addproduct'

    document.getElementById('sumbitbutton').disabled = true

    http
      .post(url2, data)
      .then((data) => {
        window.location.reload()
      })
      .catch((err) => alert('product not available'))

    document.getElementById('sumbitbutton').disabled = false
  })

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
