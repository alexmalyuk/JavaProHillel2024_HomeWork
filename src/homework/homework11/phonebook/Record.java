package homework.homework11.phonebook;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Record {
    String name;
    String number;
}
