fetch("http://localhost:8080")
  .then(res => {
    return res.json();
  })
  .then(res => {
    console.log(res);
    document.querySelector(".home").innerHTML = JSON.stringify(res);
  });
