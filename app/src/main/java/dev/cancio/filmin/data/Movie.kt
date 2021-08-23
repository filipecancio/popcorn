package dev.cancio.filmin.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Movie(
    val id: Int,
    val title: String,
    val adult: Boolean,
    val video: Boolean,
    val overview: String,
    val popularity: Double,
    @SerializedName("backdrop_path")
    private val backdropPath: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("poster_path")
    private val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("voteCount")
    val voteCount: Int,
):Serializable {

    val poster: String
        get() = "${BASE_URL}$posterPath"

    val backdrop: String
        get() = "${BASE_URL}$backdropPath"

    companion object {
        private const val BASE_URL = "https://image.tmdb.org/t/p/original"
    }
}

val movies = listOf(
    Movie(
        adult = false,
        backdropPath = "/dq18nCTTLpy9PmtzZI6Y2yAgdw5.jpg",
        genreIds = listOf(28, 12, 53, 878),
        id = 497698,
        originalLanguage = "en",
        originalTitle = "Black Widow",
        overview = "Natasha Romanoff, also known as Black Widow, confronts the darker parts of her ledger when a dangerous conspiracy with ties to her past arises. Pursued by a force that will stop at nothing to bring her down, Natasha must deal with her history as a spy and the broken relationships left in her wake long before she became an Avenger.",
        popularity = 5001.218,
        posterPath = "/qAZ0pzat24kLdO3o8ejmbLxyOac.jpg",
        releaseDate = "2021-07-07",
        title = "Black Widow",
        video = false,
        voteAverage = 7.9,
        voteCount = 3966
    ),
    Movie(
        adult = false,
        backdropPath = "/bwBmo4I3fqMsVvVtamyVJHXGnLF.jpg",
        genreIds = listOf(12, 14, 35, 28),
        id = 451048,
        originalLanguage = "en",
        originalTitle = "Jungle Cruise",
        overview = "Dr. Lily Houghton enlists the aid of wisecracking skipper Frank Wolff to take her down the Amazon in his dilapidated boat. Together, they search for an ancient tree that holds the power to heal – a discovery that will change the future of medicine.",
        popularity = 4697.639,
        posterPath = "/9dKCd55IuTT5QRs989m9Qlb7d2B.jpg",
        releaseDate = "2021-07-28",
        title = "Jungle Cruise",
        video = false,
        voteAverage = 8.0,
        voteCount = 1349
    ),
    Movie(
        adult = false,
        backdropPath = "/xXHZeb1yhJvnSHPzZDqee0zfMb6.jpg",
        genreIds = listOf(28, 80, 53),
        id = 385128,
        originalLanguage = "en",
        originalTitle = "F9",
        overview = "Dominic Toretto and his crew battle the most skilled assassin and high-performance driver they've ever encountered: his forsaken brother.",
        popularity = 3847.282,
        posterPath = "/bOFaAXmWWXC3Rbv4u4uM9ZSzRXP.jpg",
        releaseDate = "2021-05-19",
        title = "F9",
        video = false,
        voteAverage = 7.7,
        voteCount = 2381
    ),
    Movie(
        adult = false,
        backdropPath = "/jlGmlFOcfo8n5tURmhC7YVd4Iyy.jpg",
        genreIds = listOf(28, 12, 35, 878),
        id = 436969,
        originalLanguage = "en",
        originalTitle = "The Suicide Squad",
        overview = "Supervillains Harley Quinn, Bloodsport, Peacemaker and a collection of nutty cons at Belle Reve prison join the super-secret, super-shady Task Force X as they are dropped off at the remote, enemy-infused island of Corto Maltese.",
        popularity = 5835.528,
        posterPath = "/kb4s0ML0iVZlG6wAKbbs9NAm6X.jpg",
        releaseDate = "2021-07-28",
        title = "The Suicide Squad",
        video = false,
        voteAverage = 8.1,
        voteCount = 1424
    ),
    Movie(
        adult = false,
        backdropPath = "/8s4h9friP6Ci3adRGahHARVd76E.jpg",
        genreIds = listOf(16, 35, 10751, 878),
        id = 379686,
        originalLanguage = "en",
        originalTitle = "Space Jam: A New Legacy",
        overview = "When LeBron and his young son Dom are trapped in a digital space by a rogue A.I., LeBron must get them home safe by leading Bugs, Lola Bunny and the whole gang of notoriously undisciplined Looney Tunes to victory over the A.I.'s digitized champions on the court. It's Tunes versus Goons in the highest-stakes challenge of his life.",
        popularity = 3246.447,
        posterPath = "/5bFK5d3mVTAvBCXi5NPWH0tYjKl.jpg",
        releaseDate = "2021-07-08",
        title = "Space Jam: A New Legacy",
        video = false,
        voteAverage = 7.6,
        voteCount = 1608
    ),
    Movie(
        adult = false,
        backdropPath = "/gX5UrH1TLVVBwI7WxplW43BD6Z1.jpg",
        genreIds = listOf(16, 35, 12, 10751),
        id = 459151,
        originalLanguage = "en",
        originalTitle = "The Boss Baby: Family Business",
        overview = "The Templeton brothers — Tim and his Boss Baby little bro Ted — have become adults and drifted away from each other. But a new boss baby with a cutting-edge approach and a can-do attitude is about to bring them together again … and inspire a new family business.",
        popularity = 2567.943,
        posterPath = "/5dExO5G2iaaTxYnLIFKLWofDzyI.jpg",
        releaseDate = "2021-07-01",
        title = "The Boss Baby: Family Business",
        video = false,
        voteAverage = 7.9,
        voteCount = 1093
    ),
    Movie(
        adult = false,
        backdropPath = "/wPjtacig0kIkVcTQmXoNt6jbMwo.jpg",
        genreIds = listOf(28, 35),
        id = 617502,
        originalLanguage = "en",
        originalTitle = "Jolt",
        overview = "Lindy is an acid-tongued woman with rage issues who controls her temper by shocking herself with an electrode vest. One day she makes a connection with Justin, who gives her a glimmer of hope for a shock-free future, but when he’s murdered she launches herself on a revenge-fueled rampage in pursuit of his killer.",
        popularity = 2344.922,
        posterPath = "/gYZAHan5CHPFXORpQMvOjCTug4E.jpg",
        releaseDate = "2021-07-15",
        title = "Jolt",
        video = false,
        voteAverage = 6.7,
        voteCount = 417
    ),
    Movie(
        adult = false,
        backdropPath = "/620hnMVLu6RSZW6a5rwO8gqpt0t.jpg",
        genreIds = listOf(16, 35, 10751, 14),
        id = 508943,
        originalLanguage = "en",
        originalTitle = "Luca",
        overview = "Luca and his best friend Alberto experience an unforgettable summer on the Italian Riviera. But all the fun is threatened by a deeply-held secret: they are sea monsters from another world just below the water’s surface.",
        popularity = 2486.268,
        posterPath = "/jTswp6KyDYKtvC52GbHagrZbGvD.jpg",
        releaseDate = "2021-06-17",
        title = "Luca",
        video = false,
        voteAverage = 8.1,
        voteCount = 3669
    ),
    Movie(
        adult = false,
        backdropPath = "/yizL4cEKsVvl17Wc1mGEIrQtM2F.jpg",
        genreIds = listOf(28, 878),
        id = 588228,
        originalLanguage = "en",
        originalTitle = "The Tomorrow War",
        overview = "The world is stunned when a group of time travelers arrive from the year 2051 to deliver an urgent message: Thirty years in the future, mankind is losing a global war against a deadly alien species. The only hope for survival is for soldiers and civilians from the present to be transported to the future and join the fight. Among those recruited is high school teacher and family man Dan Forester. Determined to save the world for his young daughter, Dan teams up with a brilliant scientist and his estranged father in a desperate quest to rewrite the fate of the planet.",
        popularity = 2195.563,
        posterPath = "/34nDCQZwaEvsy4CFO5hkGRFDCVU.jpg",
        releaseDate = "2021-06-30",
        title = "The Tomorrow War",
        video = false,
        voteAverage = 8.2,
        voteCount = 3279
    ),
    Movie(
        adult = false,
        backdropPath = "/tehpKMsls621GT9WUQie2Ft6LmP.jpg",
        genreIds = listOf(12, 53, 28, 27, 37),
        id = 602223,
        originalLanguage = "en",
        originalTitle = "The Forever Purge",
        overview = "All the rules are broken as a sect of lawless marauders decides that the annual Purge does not stop at daybreak and instead should never end as they chase a group of immigrants who they want to punish because of their harsh historical past.",
        popularity = 2228.157,
        posterPath = "/uHA5COgDzcxjpYSHHulrKVl6ByL.jpg",
        releaseDate = "2021-06-30",
        title = "The Forever Purge",
        video = false,
        voteAverage = 7.7,
        voteCount = 864
    ),
    Movie(
        adult = false,
        backdropPath = "/wjQXZTlFM3PVEUmKf1sUajjygqT.jpg",
        genreIds = listOf(878, 28, 53),
        id = 581726,
        originalLanguage = "en",
        originalTitle = "Infinite",
        overview = "Evan McCauley has skills he never learned and memories of places he has never visited. Self-medicated and on the brink of a mental breakdown, a secret group that call themselves “Infinites” come to his rescue, revealing that his memories are real.",
        popularity = 2275.233,
        posterPath = "/niw2AKHz6XmwiRMLWaoyAOAti0G.jpg",
        releaseDate = "2021-06-10",
        title = "Infinite",
        video = false,
        voteAverage = 7.2,
        voteCount = 595
    ),
    Movie(
        adult = false,
        backdropPath = "/zm2kMjiz0u6qdn2XKbEbQkDiltN.jpg",
        genreIds = listOf(27),
        id = 675024,
        originalLanguage = "es",
        originalTitle = "El exorcismo de Carmen Farías",
        overview = "Carmen, a brave journalist, discovers soon after her mother's death that she has inherited her grandma's house. She decides to move there without knowing it hides dark secrets.",
        popularity = 1327.646,
        posterPath = "/uoTPjx07dxTrC1g3dYeaS2WNVGL.jpg",
        releaseDate = "2021-07-05",
        title = "The Exorcism of Carmen Farias",
        video = false,
        voteAverage = 6.4,
        voteCount = 47
    ),
    Movie(
        adult = false,
        backdropPath = "/6tPOZmNQ1tbzlhcMmyhYN1a1dEh.jpg",
        genreIds = listOf(28, 53),
        id = 809968,
        originalLanguage = "pl",
        originalTitle = "Bartkowiak",
        overview = "After his brother dies in a car crash, a disgraced MMA fighter takes over the family nightclub — and soon learns his sibling's death wasn’t an accident.",
        popularity = 2376.318,
        posterPath = "/kOVko9u2CSwpU8zGj14Pzei6Eco.jpg",
        releaseDate = "2021-07-28",
        title = "Bartkowiak",
        video = false,
        voteAverage = 5.9,
        voteCount = 48
    ),
    Movie(
        adult = false,
        backdropPath = "/iJ2HVOZT9Kjayrhy21pbGIJs9ey.jpg",
        genreIds = listOf(28, 12, 14),
        id = 525660,
        originalLanguage = "cn",
        originalTitle = "真·三国无双",
        overview = "Warlords, warriors and statesmen wage a battle for supremacy in this fantasy tale based on the hit video games and the \"Romance of the Three Kingdoms.\"",
        popularity = 1287.137,
        posterPath = "/7BCTdek5LFHglcgl7shsm7igJAH.jpg",
        releaseDate = "2021-04-29",
        title = "Dynasty Warriors",
        video = false,
        voteAverage = 6.4,
        voteCount = 50
    ),
    Movie(
        adult = false,
        backdropPath = "/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
        genreIds = listOf(35, 80),
        id = 337404,
        originalLanguage = "en",
        originalTitle = "Cruella",
        overview = "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
        popularity = 1439.191,
        posterPath = "/wToO8opxkGwKgSfJ1JK8tGvkG6U.jpg",
        releaseDate = "2021-05-26",
        title = "Cruella",
        video = false,
        voteAverage = 8.4,
        voteCount = 4613
    ),
    Movie(
        adult = false,
        backdropPath = "/77tui163estZrQ78NBggqDB4n2C.jpg",
        genreIds = listOf(80, 28, 53),
        id = 637649,
        originalLanguage = "en",
        originalTitle = "Wrath of Man",
        overview = "A cold and mysterious new security guard for a Los Angeles cash truck company surprises his co-workers when he unleashes precision skills during a heist. The crew is left wondering who he is and where he came from. Soon, the marksman's ultimate motive becomes clear as he takes dramatic and irrevocable steps to settle a score.",
        popularity = 1398.325,
        posterPath = "/M7SUK85sKjaStg4TKhlAVyGlz3.jpg",
        releaseDate = "2021-04-22",
        title = "Wrath of Man",
        video = false,
        voteAverage = 7.9,
        voteCount = 1790
    ),
    Movie(
        adult = false,
        backdropPath = "/3OwaKVZf3A2NdnarqKbwzFEhKir.jpg",
        genreIds = listOf(16, 14, 10751, 28, 12, 878),
        id = 730840,
        originalLanguage = "en",
        originalTitle = "Trollhunters: Rise of the Titans",
        overview = "Arcadia may look like an ordinary town, but it lies at the center of magical and mystical lines that makes it a nexus for many battles among otherworldly creatures, including trolls, aliens, and wizards. Now, various heroes will team-up in an epic adventure where they must fight the Arcane Order for control over the magic that binds them all together.",
        popularity = 1223.77,
        posterPath = "/zvUNFeTz0Sssb210wSiIiHRjA4W.jpg",
        releaseDate = "2021-07-21",
        title = "Trollhunters: Rise of the Titans",
        video = false,
        voteAverage = 7.9,
        voteCount = 131
    ),
    Movie(
        adult = false,
        backdropPath = "/c0izdYdnTe4uMRifHgvTA85wPz0.jpg",
        genreIds = listOf(28, 12, 27, 80),
        id = 503736,
        originalLanguage = "en",
        originalTitle = "Army of the Dead",
        overview = "Following a zombie outbreak in Las Vegas, a group of mercenaries take the ultimate gamble: venturing into the quarantine zone to pull off the greatest heist ever attempted.",
        popularity = 1207.675,
        posterPath = "/z8CExJekGrEThbpMXAmCFvvgoJR.jpg",
        releaseDate = "2021-05-14",
        title = "Army of the Dead",
        video = false,
        voteAverage = 6.4,
        voteCount = 2104
    ),
    Movie(
        adult = false,
        backdropPath = "/s15olg5LwRqTjgDd5KIfVXhcoqs.jpg",
        genreIds = listOf(27, 53, 28),
        id = 760883,
        originalLanguage = "de",
        originalTitle = "Blood Red Sky",
        overview = "A woman with a mysterious illness is forced into action when a group of terrorists attempt to hijack a transatlantic overnight flight. In order to protect her son she will have to reveal a dark secret, and unleash the inner monster she has fought to hide.",
        popularity = 1018.257,
        posterPath = "/ky8Fua6PD7FyyOA7JACh3GDETli.jpg",
        releaseDate = "2021-07-23",
        title = "Blood Red Sky",
        video = false,
        voteAverage = 7.2,
        voteCount = 622
    ),
    Movie(
        adult = false,
        backdropPath = "/5HjzYTihkH7EvOWSE7KcsF6pBMM.jpg",
        genreIds = listOf(10751, 35, 12, 16, 14),
        id = 522478,
        originalLanguage = "en",
        originalTitle = "Peter Rabbit 2: The Runaway",
        overview = "Bea, Thomas, and the rabbits have created a makeshift family, but despite his best efforts, Peter can’t seem to shake his mischievous reputation. Adventuring out of the garden, Peter finds himself in a world where his mischief is appreciated, but when his family risks everything to come looking for him, Peter must figure out what kind of bunny he wants to be.",
        popularity = 1081.331,
        posterPath = "/cycDz68DtTjJrDJ1fV8EBq2Xdpb.jpg",
        releaseDate = "2021-03-25",
        title = "Peter Rabbit 2: The Runaway",
        video = false,
        voteAverage = 7.4,
        voteCount = 261
    )
)