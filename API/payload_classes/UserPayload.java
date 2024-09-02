public class UserPayload {
    private String name;
    private String email;
    private String role;
    private String password;

    private UserPayload(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.role = builder.role;
        this.password = builder.password;
    }

    public static class Builder {
        private String name;
        private String email;
        private String role;
        private String password;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserPayload build() {
            return new UserPayload(this);
        }
    }
}