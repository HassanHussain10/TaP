package oslomet.testing;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class EnhetstestAdminKundeController {

    @InjectMocks
    // denne skal testes
    private AdminKundeController adminKundeController;

    @Mock
    // denne skal Mock'es
    private BankRepository repository;

    @Test
    public void test_lagreOK() {

        // arrage
        Kunde kunde1 = new Kunde(1, "Lene Jensen", "Askerveien 82");

        Mockito.when(repository.lagre((any(Kunde.class)))).thenReturn("OK");

        // act
        String resultat = adminKundeController.lagre(kunde1); // husk å bruke denne Controlleren, ikke opprett en ny!

        // assert
        assertEquals("OK", resultat);
    }

    @Test
    public void test_lagreFeil() {

        // arrage
        Kunde kunde1 = new Kunde(1, "Lene Jensen", "Askerveien 82");

        Mockito.when(repository.lagre((any(Kunde.class)))).thenReturn("Feil");

        // act
        String resultat = adminKundeController.lagre(kunde1); // husk å bruke denne Controlleren, ikke opprett en ny!

        // assert
        assertEquals("Feil", resultat);
    }

    @Test
    public void test_hentAlleOK() {

        // arrage
        Kunde kunde1 = new Kunde(1, "Lene Jensen", "Askerveien 82");
        Kunde kunde2 = new Kunde(2, "Ole Olsen", "Oslorveien 82");
        List<Kunde> kundeliste = new ArrayList<>();
        kundeliste.add(kunde1);
        kundeliste.add(kunde2);

        Mockito.when(repository.hentAlle()).thenReturn(kundeliste);

        // act
        List<Kunde> resultat = adminKundeController.hentAlle();

        // assert
        assertEquals(kundeliste, resultat);
    }

    @Test
    public void test_hentAlleFeil() {

        // arrage
        Mockito.when(repository.hentAlle()).thenReturn(null);

        // act
        List<Kunde> resultat = adminKundeController.hentAlle();

        // assert
        assertNull(resultat);
    }



    @Test
    public void test_endreOK() {

        Kunde kunde1 = new Kunde(1, "Lene Jensen", "Askerveien 82");

        Mockito.when(repository.endreEnKunde(any(Kunde.class))).thenReturn("OK");

        String restulat = adminKundeController.endreEnKunde(kunde1);
        assertEquals("OK", restulat);
    }

    @Test
    public void test_endreFeil() {

        Kunde kunde1 = new Kunde(1, "Lene Jensen", "Askerveien 82");

        Mockito.when(repository.endre(any(Kunde.class))).thenReturn("Feil");

        String restulat = adminKundeController.endreEnKunde(kunde1);
        assertEquals("Feil", restulat);
    }


    @Test
    public void test_slettOK() {

        Mockito.when(repository.slett(anyInt())).thenReturn("OK");

        String resultat = adminKundeController.slett(1);
        assertEquals("OK", resultat);
    }

    @Test
    public void test_slettFeil() {

        Mockito.when(repository.slett(anyInt())).thenReturn("Feil");

        String resultat = adminKundeController.slett(1);
        assertEquals("Feil", resultat);
    }

