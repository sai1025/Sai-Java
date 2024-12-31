$(document).ready(function () {
            $("#regForm").validate({
                rules: {
                    name: "required",
                    email: {
                        required: true,
                        email: true
                    },
                    phone: {
                        required: true,
                        digits: true,
                        minlength: 10,
                        maxlength: 10
                    },
                    address: "required",
                    department: "required",
                    designation: "required",
                    dateOfJoining: "required",
                    gender: "required",
                    imageUrl: "required"
                },
                messages: {
                    name: "Please enter your name",
                    email: "Please enter a valid email address",
                    phone: {
                        required: "Please enter your phone number",
                        digits: "Please enter only digits",
                        minlength: "Phone number should be 10 digits",
                        maxlength: "Phone number should not exceed 10 digits"
                    },
                    address: "Please enter your address",
                    department: "Please select a department",
                    designation: "Please enter your designation",
                    dateOfJoining: "Please select your date of joining",
                    gender: "Please select your gender",
                    imageUrl: "Please upload your image"
                },
                submitHandler: function (form) {
                    form.submit();
                }
            });
});
    