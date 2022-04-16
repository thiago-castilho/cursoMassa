package br.ce.wcaquino.estrategia1;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.service.UsuarioService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioServicoTest {

  private UsuarioService usuarioService = new UsuarioService();
  private static Usuario usuarioGlobal;

  @Test
  public void test_1_inserir() throws Exception {
    Usuario usuario = new Usuario("Usuario estratégia #1", "user1@email.com", "passwd");
    usuarioGlobal = usuarioService.salvar(usuario);
    Assert.assertNotNull(usuarioGlobal.getId());
  }

  @Test
  public void test_2_consultar() throws Exception {
    Usuario usuario = usuarioService.findById(usuarioGlobal.getId());
    Assert.assertEquals("Usuario estratégia #1", usuario.getNome());
  }

  @Test
  public void test_3_alterar() throws Exception {
    Usuario usuario = usuarioService.findById(usuarioGlobal.getId());
    usuario.setNome("Usuario estratégia #1 - alterado");
    Usuario usuarioAlterado = usuarioService.salvar(usuario);
    Assert.assertEquals("Usuario estratégia #1 - alterado", usuarioAlterado.getNome());
  }

  @Test
  public void test_4_excluir() throws Exception {
    usuarioService.delete(usuarioGlobal);
    Usuario usuarioRemovido = usuarioService.findById(usuarioGlobal.getId());
    Assert.assertNull(usuarioRemovido);
  }
}