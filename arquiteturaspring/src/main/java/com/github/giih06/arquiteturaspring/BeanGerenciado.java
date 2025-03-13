package com.github.giih06.arquiteturaspring;

import com.github.giih06.arquiteturaspring.todos.TodoEntity;
import com.github.giih06.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Lazy(value = false) // a classe será instanciada apenas quando for utilizada
@Component
@Scope("singleton") // cria uma instância para todos usuários, serve toda a aplicação
// @Scope("request") o objeto só existe durante uma requisição
// @Scope("session") dura enquanto a sessão do usuário durar / aplicações web
// @Scope("application") "session" so que para todos os usuários / aplicações web
// @Scope(WebApplicationContext.SCOPE_APPLICATION)
// @Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class BeanGerenciado  {

    // 3 formas de injetar uma dependência

    // via propriedade
    @Autowired
    private TodoValidator validator;

    public void utilizar() {
        var todo = new TodoEntity();
        validator.validar(todo);
    }

    // via setter ( injeção de dependência não obrigatória )
    public void setValidator(TodoValidator validator) {
        this.validator = validator;
    }

    // via construtor ( mais recomendado de utilizar / injeção obrigatória )
    public BeanGerenciado(TodoValidator validator) {
        this.validator = validator;
    }
}
