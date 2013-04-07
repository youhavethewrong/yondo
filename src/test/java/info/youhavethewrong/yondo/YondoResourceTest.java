package info.youhavethewrong.yondo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

import com.yammer.dropwizard.testing.ResourceTest;

public class YondoResourceTest extends ResourceTest {
	private final Quote testQuote = new Quote(0,
			"Lichen, mistletoe, aloft<br>In the dying croft,<br>Leaf the winter trees.");
	private final QuoteDAO dao = mock(QuoteDAO.class);

	@Override
	protected void setUpResources() throws Exception {
		addResource(new YondoResource(dao));
	}

	@Test
	public void shouldRetrieveQuote() {
		// TODO make sensible tests
		//when(dao.findContentById())).thenReturn(testQuote.getContent());
		//assertEquals("", client().resource("/quote").get(Quote.class));
	}

}
