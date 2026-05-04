package br.com.leodev.screenmovie.model;

public class Serie extends Title{
    private int seasons;
    private int episodesPerSeason;
    private boolean active;
    private int minutesPerEpisode;

    public Serie(String title, int releaseYear) {
        super(title, releaseYear);
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public int getEpisodesPerSeason() {
        return episodesPerSeason;
    }

    public void setEpisodesPerSeason(int episodesPerSeason) {
        this.episodesPerSeason = episodesPerSeason;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getMinutesPerEpisode() {
        return minutesPerEpisode;
    }

    public void setMinutesPerEpisode(int minutesPerEpisode) {
        this.minutesPerEpisode = minutesPerEpisode;
    }

    @Override
    public int getDuration() {
        return this.seasons * this.episodesPerSeason * this.minutesPerEpisode;
    }
}
