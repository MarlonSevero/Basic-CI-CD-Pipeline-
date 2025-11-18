    <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
  <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="index.jsp">My Crypto Wallet</a>
  <input class="form-control form-control-dark w-100" type="text" placeholder="Buscar Ativos" aria-label="Search">
  <ul class="navbar-nav px-3">
    <li class="nav-item text-nowrap">
      <a class="nav-link" href="index.jsp">Sair</a>
    </li>
  </ul>
</nav>

<div class="container-fluid">
  <div class="row">
    <div class="col-lg-2 ml-sm-4 pt-3 px-4">
        <nav class="col-lg-2 col-md-2 d-none d-md-block bg-light sidebar">
      <div class="sidebar-sticky">
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link active" href="index.jsp">
              <span data-feather="home"></span>
              Inicio <span class="sr-only">(current)</span>
            </a>
          </li>
        <li class="nav-item">
            <a class="nav-link" href="listausuarios">
              <span data-feather="layers"></span>
              Usuarios Cadastrados
            </a>
          </li>
        </ul>
        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
          <span>Carteira</span>
          <a class="d-flex align-items-center text-muted" href="#">
            <span data-feather="plus-circle"></span>
          </a>
        </h6>
        <ul class="nav flex-column mb-2">
          <li class="nav-item"><a class="nav-link" href="listacrypto"><span data-feather="file-text"></span> Pares de Moeda</a></li>
          <li class="nav-item"><a class="nav-link" href="listaenderecos"><span data-feather="file-text"></span> Lista Enderecos</a></li>
          <li class="nav-item"><a class="nav-link" href="listausuarios"><span data-feather="file-text"></span>Lista Usuarios</a></li>
          <li class="nav-item"><a class="nav-link" href="#"><span data-feather="file-text"></span> Compra de Ativo</a></li>
        </ul>
        </div>
    </div>
    <main role="main" class="col-lg-10 ml-sm-8 pt-3 px-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
        <h1 class="h2">Grafico</h1>
        <div class="btn-toolbar mb-2 mb-md-0">
          <div class="btn-group mr-2">
            <button class="btn btn-sm btn-outline-secondary">Print</button>
            <button class="btn btn-sm btn-outline-secondary">Exportar</button>
          </div>
          <button class="btn btn-sm btn-outline-secondary dropdown-toggle">
            <span data-feather="calendar"></span>
            Esta Semana
          </button>
        </div>
      </div>

      <canvas class="my-4" id="myChart" width="900" height="380"></canvas>

      <h2>Info Detalhada</h2>
