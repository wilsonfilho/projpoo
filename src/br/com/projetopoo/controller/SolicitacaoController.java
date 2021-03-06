package br.com.projetopoo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.projetopoo.dao.AcoesDao;
import br.com.projetopoo.dao.EmpregadoDao;
import br.com.projetopoo.dao.SolicitacaoDao;
import br.com.projetopoo.model.Acoes;
import br.com.projetopoo.model.Departamento;
import br.com.projetopoo.model.Empregado;

@Resource
public class SolicitacaoController {

	private final Result result;
	private final SolicitacaoDao solicitacaoDao;
	private final EmpregadoDao empregadoDao;
	private final AcoesDao acoesDao;
	
	public SolicitacaoController(Result result, SolicitacaoDao solicitacaoDao, EmpregadoDao empregadoDao,AcoesDao acoesDao ) {
		
		this.result = result;
		this.solicitacaoDao = solicitacaoDao;
		this.empregadoDao = empregadoDao;
		this.acoesDao = acoesDao;
	}
	
	@Get({"", "/solicitarabono"})
	public List<Empregado> solicitarAbono() {
		
		return solicitacaoDao.findAll(new Empregado());
	}
	
	@Post("/solicitacao/salvar")
	public void solicitacaoSalvar(Empregado empregado, Acoes acao, String dataInicio, String dataFim) throws ParseException {
		
		empregado = empregadoDao.findBy("id", empregado);
		
		acao.setEmpregado(empregado);
		acao.setTipoAcao('S');
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		Date dataInicial = null;
		Date dataFinal = null;
		
		dataInicial = sdf.parse(dataInicio);
		dataFinal = sdf.parse(dataFim);
		
		acao.setDataInicio(dataInicial);
		acao.setDataFim(dataFinal);
		
		Departamento departamento = new Departamento(empregado.getDepartamento().getId());
		
		Empregado gestor = empregadoDao.findGestorDepartamento(departamento);
		
		acao.setGestor(gestor);
		
		acoesDao.save(acao);
		
		result.redirectTo(this).solicitarAbono();
	}
	
	@Get("/autorizarsolicitacao")
	public List<Acoes> autorizarSolicitacao() {
		
		return acoesDao.todasSolicitacoes();
	}
	
	@Get("/avaliarsolicitacao")
	public List<Acoes> avaliarSolicitacao() {
		
		return acoesDao.todasSolicitacoesAvaliar();
	}
	
	@Post("/solicitacao/recusar")
	public void recusarSolicitacao(Integer id) {
		
		Acoes acao = new Acoes(id);
		acao = acoesDao.findBy("id", acao);
		
		// R -> Recusado
		acao.setTipoAcao('R');
		acoesDao.update(acao);
		
		result.use(Results.json()).withoutRoot().from("sucesso").serialize();
	}
	
	@Post("/solicitacao/aprovar")
	public void aprovarSolicitacao(Integer id) {
		
		Acoes acao = new Acoes(id);
		acao = acoesDao.findBy("id", acao);
		
		// A -> Avaliar
		acao.setTipoAcao('A');
		acoesDao.update(acao);
		
		result.use(Results.json()).withoutRoot().from("sucesso").serialize();
	}
	
	@Post("/solicitacao/retornar")
	public void retornarSolicitacao(Integer id, String observacao) {
		
		Acoes acao = new Acoes(id);
		acao = acoesDao.findBy("id", acao);
		acao.setObservacao(observacao);
		
		// B -> Back(Retorno)
		acao.setTipoAcao('B');
		acoesDao.update(acao);
		
		result.redirectTo(this).avaliarSolicitacao();
	}
	
	@Post("/solicitacao/aprovarSolicitacaoRh")
	public void aprovarSolicitacaoRh(Integer id, String observacao) {
		
		Acoes acao = new Acoes(id);
		acao = acoesDao.findBy("id", acao);
		acao.setObservacao(observacao);
		
		// B -> Back(Retorno)
		acao.setTipoAcao('P');
		acoesDao.update(acao);
		
		result.use(Results.json()).withoutRoot().from("sucesso").serialize();
	}
}
