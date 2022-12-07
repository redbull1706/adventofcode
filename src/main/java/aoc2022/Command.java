package aoc2022;

public enum Command {
	CD {
		@Override
		void execute(Commander commander, String command) {
			//System.out.println(command);
			MyFile root = commander.getRoot();
			String[] split = command.split(" ");
			String name = split[2];
			if(name.equals("..")) {
				if(!root.getName().equals("root")) {
					commander.moveDirUp();
				}else {
					commander.gotoRoot();
				}
			}else if(name.equals("/")) {
				commander.gotoRoot();
			}else if(commander.getDirectoryTree().containsKey((root.getName()+"|"+name))){
				commander.cd(root.getName()+"|"+name);
			}
		}
	},LS {
		@Override
		void execute(Commander commander, String command) {
			//doNothing
			//System.out.println(command);
		}
	},DIR {
		@Override
		void execute(Commander commander, String command) {
			//System.out.println(command);
			String[] split = command.split(" ");
			String name = split[1];
			commander.add( name);
		}
	}, FILE {
		@Override
		void execute(Commander commander, String command) {
			//System.out.println(command);
			String[] split = command.split(" ");
			 double size = Long.parseLong(split[0]);
			 String name = split[1];
			 commander.add(new MyFile(name,size, commander.getRoot()));
		}
	};
	
	public static final Command getByInput(String input) {
		String[] split = input.split(" ");
		if(input.startsWith("$")) {
			if(split[1].equals("cd")) {
				return Command.CD;
			}else if(split[1].equals("ls")) {
				return Command.LS;
			}
		}else if(split[0].equals("dir")) {
			return Command.DIR;
		}
		return Command.FILE;
	}
	
	abstract void execute(Commander commander, String command);

}
