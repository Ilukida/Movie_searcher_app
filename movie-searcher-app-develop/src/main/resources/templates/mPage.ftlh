<#ftl encoding='UTF-8'>
<#include "base.ftlh">
<#macro title> ${movie.name}</#macro>
<#macro main>
    <div class="container main__container">
        <div class="row movie__info">
            <div class="col-md-3 movie__info__image">
                <img src="${movie.imageUrl}" alt="movie image">
            </div>
            <div class="col-md-7 movie__info__info">
                <div class="container-fluid">
                    <div class="row movie__title">
                        <div class="col-md-12">
                            <h1><strong>${movie.name}</strong></h1>
                        </div>
                    </div>
                    <div class="row movie__info__about">
                        <div class="col-md-12">
                            <p class="h3">О фильме</p>
                            <table class="table table-hover movie__info__about__table">
                                <tr>
                                    <td class="text__grey">Год выпуска</td>
                                    <td>${movie.dateOfRelease}</td>
                                </tr>
                                <tr>
                                    <td class="text__grey">Страна</td>
                                    <td>${movie.country}</td>
                                </tr>
                                <tr>
                                    <td class="text__grey">Жанр</td>
                                    <td>${movie.genreName}</td>
                                </tr>
                                <tr>
                                    <td class="text__grey">Премьера</td>
                                    <td>${movie.dateOfRelease}</td>
                                </tr>
                                <tr>
                                    <td class="text__grey">Длительность</td>
                                    <td>164 минуты</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                    <div class="movie__info__review_btn__wrapper">
                        <a href="/reviews/${movie.id}" class="btn ">Написать рецензию</a>
                    </div>
            </div>
            <div class="col-md-2 movie__info__info">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12 movie__info__info__rating ">
                            <p class="h1 text-center movie__rating__value"><strong><#if movie.averageRating??>${movie.averageRating}<#else>0</#if>/100</strong></p>
                            <a href="#" class="text-dark">
                                <p class="text-center">24 рецензии</p>
                            </a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 movie__info__participants">
                                <span class="text-secondary text-center movie__info__participants__header">
                                    В главных ролях:
                                </span>
                            <ul class="list-unstyled text__grey">
                                <#list movie.persons as person>
                                    <li>
                                        <a href="/person?id=${person.id}" class="link__grey">
                                            ${person.firstName} ${person.lastName}
                                        </a>
                                    </li>
                                </#list>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row movie__description__row">
                <div class="col-md-10 movie__description">
                    <p class="h3">Обзор</p>
                    <p>${movie.description}</p>
                </div>
            </div>

            <div class="row movie__comments__row">
                <div class="col-md-10 offset-md-1 movie__comments">
                    <div class="movie__comments__form__wrapper">
                            <p class="h5 movie__comments__header"><strong>Оставить комментарий</strong></p>
                            <form method="post" action="/movies/comment">
                                <div class="form-group">
                                    <input class="form-control" type="text" name="movieId" value="${movie.id}" hidden  readonly>
                                    <label for="comment_text">Текст комментария</label>
                                    <textarea name="text" class="form-control .form-control-lg" id="comment_text" rows="3"></textarea>
                                    <small id="emailHelp" class="form-text text-muted">не более 200 символов</small>
                                </div>
                                <br>
                                <button type="submit" class="btn ">Оставить комментарий</button>
                            </form>
                    </div>

                    <div class="movie__comments__header__wrapper">
                        <p class="h3 movie__comments__header"><strong>Комментарии <sup>${movie.commentaries?size}</sup></strong></p>
                    </div>
                    <div class="movie__comments__list__wrapper">
                        <ul class="list-unstyled movie__comments__list">
                            <#list movie.commentaries as comment>
                                <li>
                                    <div class="movie__comments__list__elem">
                                        <p>
                                            <span class="movie__comment__created_at">${comment.createDate}</span>
                                            <span class="movie__comment__username">
                                                <a href="/profile/${comment.username}" class="link__grey">
                                                    ${comment.username}
                                                </a>:
                                            </span>
                                        </p>
                                        <p class="movie__comment__text">${comment.text}</p>
                                    </div>
                                </li>
                            </#list>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</#macro>