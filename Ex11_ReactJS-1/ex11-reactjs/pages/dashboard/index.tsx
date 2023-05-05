function Dashboard() {
  const userName = localStorage.getItem("userName");
  return <div>hello {userName}</div>;
}

export default Dashboard;
