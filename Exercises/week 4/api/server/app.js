const express = require("express");
const bodyParser = require("body-parser");
const studentRouter = require("./modules/student/student.router");
const mongoose = require("mongoose");
const config = require("./config");
const cors = require("cors");

mongoose.connect(config.mongoConnectionString);
const PORT = process.env.PORT || 9999;

const app = express();
app.use(cors());
app.use(bodyParser.json());
// app.use("/", express.static("../client"));

app.use("/api/student", studentRouter);

app.listen(PORT, function () {
  console.log(`Server is listening on ${PORT}`);
});
