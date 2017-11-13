//@@author cqhchan
package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_PASSWORD_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_USERNAME_DESC;
import static seedu.address.logic.commands.CommandTestUtil.PASSWORD_DESC_PASSWORD;
import static seedu.address.logic.commands.CommandTestUtil.USERNAME_DESC_USERNAME;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PASSWORD_PASSWORD;
import static seedu.address.logic.commands.CommandTestUtil.VALID_USERNAME_PRIVATE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;

import org.junit.Test;

import seedu.address.logic.commands.CreateAccountCommand;
import seedu.address.model.account.Password;
import seedu.address.model.account.Username;

public class CreateAccountCommandParserTest {
    private CreateAccountCommandParser parser = new CreateAccountCommandParser();


    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, CreateAccountCommand.MESSAGE_USAGE);

        // missing username prefix
        assertParseFailure(parser, CreateAccountCommand.COMMAND_WORD + VALID_USERNAME_PRIVATE
                + PASSWORD_DESC_PASSWORD , expectedMessage);

        // missing password prefix
        assertParseFailure(parser, CreateAccountCommand.COMMAND_WORD + USERNAME_DESC_USERNAME
                + VALID_PASSWORD_PASSWORD , expectedMessage);

    }
    @Test
    public void parse_invalidValue_failure() {
        // invalid name
        assertParseFailure(parser, CreateAccountCommand.COMMAND_WORD + INVALID_USERNAME_DESC
                + PASSWORD_DESC_PASSWORD, Username.MESSAGE_NAME_CONSTRAINTS);

        // invalid Password
        assertParseFailure(parser, CreateAccountCommand.COMMAND_WORD + USERNAME_DESC_USERNAME
                + INVALID_PASSWORD_DESC, Password.MESSAGE_PASSWORD_CONSTRAINTS);



    }

}
