package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.util.TypicalPersons;

import java.util.HashSet;
import java.util.Iterator;

public class SortCommandTest {
    private TypicalPersons td = new seedu.addressbook.util.TypicalPersons();

    private AddressBook typicalAddressBook = td.getTypicalAddressBook();

    @Test
    public void sortCommand_correctlySorted() throws IllegalValueException {

        typicalAddressBook.addPerson(new Person(
                new Name("Zony"),
                new Phone("86769898", false),
                new Email("zony@gmail.com", false),
                new Address("Richman Road, #99-88", false),
                new HashSet<>()
        ));

        typicalAddressBook.addPerson(new Person(
                new Name("Wonky"),
                new Phone("86555898", false),
                new Email("wonky@gmail.com", false),
                new Address("Goodwill Street 88, #99-88", false),
                new HashSet<>()
        ));

        UniquePersonList allPerson = typicalAddressBook.getAllPersons();
        allPerson.sort();

        assertEquals(true, isSorted(allPerson));
    }

    /**
     * Check if the given list is sorted in natural order of name
     * @param list the list containing all the person
     * @return true for sorted order, false otherwise
     */
    private boolean isSorted(UniquePersonList list) {
        Iterator<Person> it = list.iterator();
        Name n1 = it.next().getName();
        while(it.hasNext()) {
            Name n2 = it.next().getName();
            if (n1.compareTo(n2) > 0) {
                return false;
            }
        }

        return true;
    }
}