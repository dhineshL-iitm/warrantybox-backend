const http = new EasyHTTP()
const url = window.location.origin + '/user/top'
const tvshowsdata = http
  .get(url)
  .then((data) => {
    console.log(data)
    let tvshows = [...new Map(data.map((item) => [item['id'], item])).values()]
    for (let index = 0; index < tvshows.length; index++) {
      const element = tvshows[index]
      let genretag = ``
      for (let index = 0; index < element.genres.length; index++) {
        const genre = element.genres[index]
        genretag += `<div class='btn btn-primary'>${genre}</div>`
      }
      let ratingtag = ``
      const ratings = Math.ceil(element.rating / 2)
      for (let index = 0; index < ratings; index++) {
        ratingtag += `<span class="fa fa-star fa-2x starcolor"></span>`
      }
      for (let index = 0; index < 5 - ratings; index++) {
        ratingtag += `<span class="fa fa-star fa-2x"></span>`
      }

      let popularTag = ``
      if (element.popular > 70) {
        popularTag = `<div class="container p-10">
              <div class="row bg-danger center">
                <p>Popular on Tvservice</p>
              </div>
            </div>`
      }
      const tvshow =
        `<div class="row tvshow">
        <div class="d-flex">
          <div class="flex-fill p-2">
            <div class="polaroid center">
              <img
                src=${element.imageUrl}
                alt="Norther Lights"
                width="210px"
                height="295px"
              />
              <div class="container star-container">
                <p>
                  ` +
        ratingtag +
        `
                </p>
              </div>
            </div>
            <button class="btn btn-danger" >Likes :${element.likes}</button>
            <button class="btn btn-primary likebutton" id=${
              element.id
            }>Like</button>
            <button class="btn btn-primary savebutton" id=${
              element.id
            }>SaveShow</button>
          </div>
          <div class="flex-fill p-2 center bg-dark">
            <h1 class="center text-white">${element.name}<span> ${
          element.language != null ? '(' + element.language + ')' : ''
        }</span></h1>
            <p>
            ${element.summary != null ? element.summary : ''}
            </p>
            <div class="d-flex justify-content-between center">
              <span class="genre"
                ><div class="">` +
        genretag +
        `</div></span
              >
            </div>
            ` +
        popularTag +
        `
          </div>
        </div>
      </div>`
      document.getElementById('tvshows').innerHTML += tvshow
    }

    return data
  })
  .catch((error) => console.log(error))

const liketvshow = tvshowsdata.then((data) => {
  document.getElementById('tvshows').addEventListener('click', (e) => {
    if (e.target.classList.contains('likebutton')) {
      const likedtvshow = data.find((x) => x.id == e.target.id)
      e.target.classList.remove('btn-primary')
      e.target.classList.add('btn-success')
      alert('like added')

      const url = window.location.origin + '/user/like'
      http
        .post(url, likedtvshow)
        .then((data) => console.log(data))
        .catch((err) => console.log(err))
    }
  })
})

const savetvshow = tvshowsdata.then((data) => {
  document.getElementById('tvshows').addEventListener('click', (e) => {
    if (e.target.classList.contains('savebutton')) {
      e.target.classList.remove('btn-primary')
      e.target.classList.add('btn-success')
      const likedtvshow = data.find((x) => x.id == e.target.id)

      const url = window.location.origin + '/user/saveshow'
      http
        .post(url, likedtvshow)
        .then((data) => console.log(data))
        .catch((err) => console.log(err))
    }
  })
})
