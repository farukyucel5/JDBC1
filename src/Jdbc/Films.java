package Jdbc;

public class Films {
    private String title;
    private String description;
    private String release_year;

    private String language_id;
    Films(String title, String description, String release_year,String language_id) {
        this.title=title;
        this.description=description;
        this.release_year=release_year;
        this.language_id=language_id;
    }


}
