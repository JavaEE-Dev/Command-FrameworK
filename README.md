# Command Framework

--------------
* How to use?
  - Clone this repository 
  - Follow the example

* Can I fork?
  - Obviously it is open source!
--------------

Example:

```
public class ExampleCommand extends ACommand {
    public ExampleCommand() {
        super("example", Arrays.asList("shit", "ass"), false, false);
    }

    @Override
    public void execute(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.RED + "Hello!");
    }
}
```
