fetch('http://localhost:8080/getStudents')
    .then((res) => {
        return res.json()
    })
    .then((res) => {
        document.querySelector('.students').innerHTML = res.map((item) => {
            return `
                <div>
                    <div>Name: ${item.name}</div>
                    <div>Age: ${item.age}</div>
                    <div>Dob: ${item.dob}</div>
                    <div>Khoa: ${item.khoa}</div>
                </div>
            `
        }).join("")
    })

