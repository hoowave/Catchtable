function join(){

    let joinData = {
        name: $('#joinname').val(),
        phone: $('#joinphone').val(),
        password: $('#joinpassword1').val(),
        nickname: $('#joinnickname').val(),
        peristalsis: $('#peristalsis').is(':checked') ? $('#peristalsis').val() : 'N',
        terms_1: $('#terms_1').is(':checked') ? $('#terms_1').val() : 'N',
        terms_2: $('#terms_2').is(':checked') ? $('#terms_2').val() : 'N',
        terms_3: $('#terms_3').is(':checked') ? $('#terms_3').val() : 'N',
        terms_4: $('#terms_4').is(':checked') ? $('#terms_4').val() : 'N',
        terms_5: $('#terms_5').is(':checked') ? $('#terms_5').val() : 'N',
        terms_6_1: $('#terms_6_1').is(':checked') ? $('#terms_6_1').val() : 'N',
        terms_6_2: $('#terms_6_2').is(':checked') ? $('#terms_6_2').val() : 'N',
        terms_6_3: $('#terms_6_3').is(':checked') ? $('#terms_6_3').val() : 'N',
    };

    $.ajax({
        type: 'POST',
        url: '/ct/join',
        data: JSON.stringify(joinData),
        contentType: 'application/json',
        success: function(response) {
            alert(response);
            location.href = "/ct/login";
        },
        error: function(xhr, status, error) {
            alert('Error: ' + xhr.responseText);
        }
    });
}

function nicknameCheck(){

    let data = {
        nickname: $('#joinnickname').val()
    };

    $.ajax({
        type: 'POST',
        url: '/ct/nicknamechk',
        data: JSON.stringify(data),
        contentType: 'application/json',
        success: function(response) {
            alert(response);
        },
        error: function(xhr, status, error) {
            alert(xhr.responseText);
        }
    });
}

function login(){

    let loginData = {
        nickname: $('#loginid').val(),
        password: $('#loginpw').val(),
    };

    $.ajax({
        type: 'POST',
        url: '/ct/login',
        data: JSON.stringify(loginData),
        contentType: 'application/json',
        success: function(response) {
            alert(response);
            location.href = "/";
        },
        error: function(xhr, status, error) {
            alert(xhr.responseText);
        }
    });
}