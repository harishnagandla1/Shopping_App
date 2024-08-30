public class Pet {
    private String name;
    private String status;
    private String id;

    private Pet(PetBuilder builder) {
        this.name = builder.name;
        this.status = builder.status;
        this.id = builder.id;
    }

    public static class PetBuilder {
        private String name;
        private String status;
        private String id;

        public PetBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PetBuilder setStatus(String status) {
            this.status = status;
            return this;
        }

        public PetBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public Pet build() {
            return new Pet(this);
        }
    }
}