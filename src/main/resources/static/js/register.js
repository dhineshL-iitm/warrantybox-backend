const http = new EasyHTTP()

document
  .getElementById('register-form')
  .addEventListener('submit', function (e) {
    const usernamevalue = document.getElementById('username').value,
      passwordvalue = document.getElementById('password').value,
      typevalue = document.getElementById('type').value,
      emailvalue = document.getElementById('email').value

    data = {
      username: usernamevalue,
      password: passwordvalue,
      type: typevalue,
      email: emailvalue,
    }

    url = window.location.origin + '/register'

    document.getElementById('sumbitbutton').disabled = true

    http
      .post(url, data)
      .then((data) => {
        if (data.status == '409') {
          alert('Username taken')
        } else {
          window.location = window.location.origin
        }
      })
      .catch((err) => console.log('error', err))
    e.preventDefault()
    document.getElementById('sumbitbutton').disabled = false
  })
