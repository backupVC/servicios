public class Conexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(), 
				CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		 MongoClient mongoClient = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
		 MongoDatabase database = mongoClient.getDatabase("ejercicio").withCodecRegistry(pojoCodecRegistry);
		 MongoCollection<User> collection =  database.getCollection("users", User.class);
		 User user = new User(50000, "victoria" , "garcía garcía", "victoriiia@garcia.es");
		/*collection.insertOne(user);
		 User somebody = collection.find().first();
		 System.out.println(somebody);
		 List<User> people = Arrays.asList(
	                new User(500001, "victor" , "garcía garcía", "victor@garcia.es"),
	                new User(500002, "vitorio" , "garcía garcía", "vitorio@garcia.es"),
	                new User(500003, "bart" , "garcía garcía", "bart@garcia.es"));
		 
		 collection.insertMany(people);*/
		 System.out.println("total # of people " + collection.count());
		 Block<User> printBlock = new Block<User>() {
	            @Override
	            public void apply(final User person) {
	                System.out.println(person.getId() + "--" + person);
	            }
		 };
		 collection.find().forEach(printBlock);
		 
		 System.out.println("");
	        // now use a query to get 1 document out
	      User  somebody = collection.find(eq("first_name", "victor")).first();
	      System.out.println(somebody);
	   // Update One
	      collection.updateOne(eq("first_name", "victoria"), combine(set("last_name", "jiménez jiménez"), set("email", "another@one.es")));
	    
	      somebody = collection.find(eq("first_name", "victoria")).first();
	      System.out.println(somebody);
	      System.out.println("total # of people " + collection.count());
	      collection.deleteOne(eq("first_name", "bart"));
	      System.out.println("total # of people " + collection.count());
	      mongoClient.close();
	}

}

