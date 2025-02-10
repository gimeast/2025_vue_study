export async function login(username, password) {
  //API로 대체돼야함
  const response = { username: 'username', password: 'password' }
  if (username === response.username && password === response.password) {
    return { token: 'testToken12345' }
  } else {
    throw new Error('Invalid credentials')
  }
}
