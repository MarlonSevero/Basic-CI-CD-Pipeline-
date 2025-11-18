document.addEventListener("DOMContentLoaded", () => {
  // Scroll suave
  const links = document.querySelectorAll('a[href^="#"]');
  links.forEach(link => {
    link.addEventListener("click", e => {
      const href = link.getAttribute("href");
      if (href === "#") return;
      e.preventDefault();
      const target = document.querySelector(href);
      if (target) target.scrollIntoView({ behavior: "smooth" });
    });
  });

  // Destaque da seção ativa
  const sections = document.querySelectorAll("section[id]");
  const navLinks = document.querySelectorAll(".navbar-nav .nav-link[href^='#']");
  const observer = new IntersectionObserver(entries => {
    entries.forEach(entry => {
      const id = entry.target.getAttribute("id");
      const link = document.querySelector(`.navbar-nav .nav-link[href="#${id}"]`);
      if (link) {
        if (entry.isIntersecting) {
          navLinks.forEach(l => l.classList.remove("active"));
          link.classList.add("active");
        }
      }
    });
  }, { threshold: 0.6 });
  sections.forEach(section => observer.observe(section));

  // Fecha menu mobile ao clicar
  const navToggler = document.querySelector(".navbar-toggler");
  const navCollapse = document.querySelector(".navbar-collapse");
  document.querySelectorAll(".navbar-nav .nav-link").forEach(link =>
    link.addEventListener("click", () => {
      if (window.innerWidth < 992 && navCollapse.classList.contains("show")) {
        navToggler.click();
      }
    })
  );

  // Campos
  const name_user = document.getElementById("name_user");
  const dt_nascimento = document.getElementById("dt_nascimento");
  const renda = document.getElementById("renda");
  const email = document.getElementById("email");
  const senha = document.getElementById("passwd");
  const conf_passwd = document.getElementById("conf_passwd");
  const cidade = document.getElementById("cidade");
  const bairro = document.getElementById("bairro");
  const rua = document.getElementById("rua");
  const numero = document.getElementById("numero");
  const complemento = document.getElementById("complemento");
  const cpf = document.getElementById("cpf");
  const btnSubmit = document.getElementById("btn_submit");

  // Função para criar alertas
  function criarAlerta(campo, mensagem, marginTop = "mt-1") {
    const alerta = document.createElement("div");
    alerta.className = `alert alert-danger ${marginTop} d-none`;
    alerta.role = "alert";
    alerta.innerText = mensagem;
    campo.parentNode.appendChild(alerta);
    return alerta;
  }

  // Criando alertas
  const alertaNome = criarAlerta(name_user, "O nome deve ter mais de 3 letras e não pode conter números.");
  const alertaNascimento = criarAlerta(dt_nascimento, "Informe uma data válida no formato dd/mm/aaaa.");
  const alertaRenda = criarAlerta(renda, "A renda deve ser um número maior que zero.");
  const alertaEmail = criarAlerta(email, "O email tem que ser valido.");
  const alertaSenha = criarAlerta(conf_passwd, "As senhas não coincidem!", "mt-2");
  const alertaCpf = criarAlerta(cpf, "O CPF deve conter 11 dígitos numéricos.");


  // Validações
  function nomeValido(nome) {
    const temNumero = /\d/.test(nome);
    return nome.trim().length > 3 && !temNumero;
  }

  function dataNascimentoValida(dataStr) {
    const regex = /^(\d{2})\/(\d{2})\/(\d{4})$/;
    const match = dataStr.match(regex);
    if (!match) return false;
    const dia = parseInt(match[1], 10);
    const mes = parseInt(match[2], 10) - 1;
    const ano = parseInt(match[3], 10);
    const data = new Date(ano, mes, dia);
    return (
      data.getDate() === dia &&
      data.getMonth() === mes &&
      data.getFullYear() === ano
    );
  }

  function emailValido(email) {
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
  }

function cpfValido(cpf) {
  const apenasNumeros = cpf.replace(/\D/g, '');
  return apenasNumeros.length === 11;
}

  function validarFormulario() {
    const nomePreenchido = name_user.value.trim() !== "" && nomeValido(name_user.value);
    const nascimentoPreenchido = dt_nascimento.value.trim() !== "" && dataNascimentoValida(dt_nascimento.value);
    const rendaPreenchida = renda.value.trim() !== "" && parseFloat(renda.value) > 0;
    const emailPreenchido = email.value.trim() !== "" && emailValido(email.value);
    const senhaOk = senha.value.trim() !== "" && senha.value === conf_passwd.value;

    const cidadePreenchida = cidade.value.trim() !== "";
    const bairroPreenchido = bairro.value.trim() !== "";
    const ruaPreenchida = rua.value.trim() !== "";
    const numeroPreenchido = numero.value.trim() !== "";
    const complementoPreenchido = complemento.value.trim() !== "";
    const cpfPreenchido = cpf.value.trim() !== "" && cpfValido(cpf.value);

    alertaNome.classList.toggle("d-none", nomePreenchido || name_user.value.trim() === "");
    alertaNascimento.classList.toggle("d-none", nascimentoPreenchido || dt_nascimento.value.trim() === "");
    alertaRenda.classList.toggle("d-none", rendaPreenchida || renda.value.trim() === "");
    alertaEmail.classList.toggle("d-none", emailValido(email.value) || email.value.trim() === "");
    alertaSenha.classList.toggle("d-none", senhaOk || (!senha.value && !conf_passwd.value));
    alertaCpf.classList.toggle("d-none", cpfPreenchido || cpf.value.trim() === "");

    const formValido =
      nomePreenchido &&
      nascimentoPreenchido &&
      rendaPreenchida &&
      emailPreenchido &&
      senhaOk &&
      cidadePreenchida &&
      bairroPreenchido &&
      ruaPreenchida &&
      numeroPreenchido &&
      complementoPreenchido &&
      cpfPreenchido;

    btnSubmit.disabled = !formValido;
  }

  // Escuta inputs
  [
    name_user,
    dt_nascimento,
    renda,
    email,
    senha,
    conf_passwd,
    cidade,
    bairro,
    rua,
    numero,
    complemento,
    cpf
  ].forEach(input => {
    input.addEventListener("input", validarFormulario);
  });

  // Botão começa desabilitado
  btnSubmit.disabled = true;
});