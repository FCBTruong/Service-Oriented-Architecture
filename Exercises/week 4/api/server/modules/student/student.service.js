const repository = require("./student.repository.js");

const find = async function (query) {
  console.log(query);
  return await repository.find(query);
};

const findById = async function (id) {
  const idToQuery = { mssv: id };
  console.log(Object.assign(idToQuery));
  // console.log(id);
  return await repository.find(idToQuery);
};

const create = async function (data) {
  // Validate
  if (!data) {
    throw new Error("Missing input!");
  }

  return await repository.create(data);
};

const update = async function (id, data) {
  // Validate
  const existedRecord = await repository.findById(id);
  if (!existedRecord) {
    throw new Error("Entity not found");
  }

  return await repository.update(id, data);
};

const deleteOne = async function (id) {
  // Validate
  const existedRecord = await repository.findById(id);
  if (!existedRecord) {
    throw new Error("Entity not found");
  }

  return await repository.delete(id);
};

module.exports = {
  find: find,
  findById: findById,
  create: create,
  update: update,
  delete: deleteOne,
};
