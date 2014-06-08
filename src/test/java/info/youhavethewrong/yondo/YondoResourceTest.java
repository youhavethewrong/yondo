package info.youhavethewrong.yondo;

import static org.mockito.Mockito.mock;
import io.dropwizard.testing.junit.ResourceTestRule;

import org.junit.*;

public class YondoResourceTest {

    // private final Quote testQuote = new Quote(0,
    // "Lichen, mistletoe, aloft<br>In the dying croft,<br>Leaf the winter trees.");
    private final static QuoteDAO dao = mock(QuoteDAO.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder().addResource(new YondoResource(dao)).build();

    public void shouldRetrieveQuote() {
	// TODO make sensible tests
	// when(dao.findContentById())).thenReturn(testQuote.getContent());
	// assertEquals("", client().resource("/quote").get(Quote.class));
    }

}
