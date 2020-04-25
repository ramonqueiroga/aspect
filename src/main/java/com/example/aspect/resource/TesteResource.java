package com.example.aspect.resource;

import com.example.aspect.Entity.BilheteEntity;
import com.example.aspect.Entity.Player;
import com.example.aspect.Entity.ReservaEntity;
import com.example.aspect.Entity.SoccerTeam;
import com.example.aspect.service.PlayerService;
import com.example.aspect.service.ReservaService;
import com.example.aspect.service.SoccerTeamService;
import com.example.aspect.service.TesteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class TesteResource {

    @Autowired
    private TesteService testeService;

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private SoccerTeamService soccerTeamService;

    @Autowired
    private PlayerService playerService;


    @RequestMapping(value = "/api/aspect", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<?> testeRource() {
        String nome = "Ramon-Araujo-Queiroga";
        return ResponseEntity.ok(this.testeService.meuNome(nome));
    }

    @RequestMapping(value = "/api/reserva", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<?> criaReserva() {
        ReservaEntity reservaEntity = this.criaReservaCompleta();
        ReservaEntity save = this.reservaService.save(reservaEntity);
        return ResponseEntity.ok(save);
    }

    @RequestMapping(value = "/api/soccer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<?> createSoccerTeamWithPlayers() {
        SoccerTeam soccerTeam = this.createCompleteSoccerTeam();
        SoccerTeam save = this.soccerTeamService.save(soccerTeam);
        return ResponseEntity.ok(save);
    }

    @RequestMapping(value = "/api/reserva/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<?> buscaTodasReservas() {
        return ResponseEntity.ok(this.reservaService.findAll());
    }

    private ReservaEntity criaReservaCompleta() {
        ReservaEntity reservaEntity = new ReservaEntity();
        reservaEntity.setLocalizador("ABC123");

        BilheteEntity bilheteEntity = new BilheteEntity();
        bilheteEntity.setNumero("1234");
        bilheteEntity.setReservaEntity(reservaEntity);
        reservaEntity.addBilhete(bilheteEntity);

        bilheteEntity = new BilheteEntity();
        bilheteEntity.setNumero("4321");
        bilheteEntity.setReservaEntity(reservaEntity);
        reservaEntity.addBilhete(bilheteEntity);

        return reservaEntity;
    }

    private SoccerTeam createCompleteSoccerTeam() {
        SoccerTeam soccerTeam = new SoccerTeam();
        soccerTeam.setName("Corinthians");

        Player player = this.createPlayer(99, "Ramon", "Queiroga");
        Player player1 = this.createPlayer(99, "Fernanda", "Queiroga");

        soccerTeam.setPlayers(Arrays.asList(player, player1));
        return soccerTeam;
    }

    private Player createPlayer(Integer habilidade, String name, String sobrenome) {
        Player player = new Player();
        player.setHability(habilidade);
        player.setName(name);
        player.setSurname(sobrenome);
        return player;
    }

}