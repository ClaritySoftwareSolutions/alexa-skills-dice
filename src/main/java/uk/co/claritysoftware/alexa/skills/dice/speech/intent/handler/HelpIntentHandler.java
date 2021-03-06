package uk.co.claritysoftware.alexa.skills.dice.speech.intent.handler;

import static com.amazon.speech.speechlet.SpeechletResponse.newAskResponse;
import static uk.co.claritysoftware.alexa.skills.speech.factory.RepromptFactory.whatNextReprompt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.CoreSpeechletRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import uk.co.claritysoftware.alexa.skills.speech.intent.IntentHandler;

/**
 * {@link IntentHandler} for the Help intent
 */
public class HelpIntentHandler implements IntentHandler {

	private static final Logger LOG = LoggerFactory.getLogger(HelpIntentHandler.class);

	@Override
	public SpeechletResponse handleIntent(final SpeechletRequestEnvelope<? extends CoreSpeechletRequest> requestEnvelope) {
		LOG.debug("handleIntent requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
				requestEnvelope.getSession().getSessionId());

		final String speechText = "You can ask me to roll a dice for you. What would you like me to do?";

		final PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText(speechText);

		return newAskResponse(speech, whatNextReprompt());
	}
}
