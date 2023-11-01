package ru.tour_base.data_main.data.mappers

import ru.tour_base.data_main.domain.entity.main.Button
import ru.tour_base.data_main.domain.entity.main.Content
import ru.tour_base.data_main.domain.entity.main.MainContent
import ru.tour_base.data_main.domain.entity.main.Template
import ru.tour_base.data_main.network.entity.main.ButtonApiEntity
import ru.tour_base.data_main.network.entity.main.ContentApiEntity
import ru.tour_base.data_main.network.entity.main.MainContentApiEntity
import ru.tour_base.data_main.network.entity.main.TemplateApiEntity

fun MainContentApiEntity.toDomain() =
    MainContent(
        buttons = data.buttons.map { it.toDomain() },
        content = data.content.map { it.toDomain() }
    )

private fun ButtonApiEntity.toDomain() = Button(color, icon, title, type, url)
private fun ContentApiEntity.toDomain() = Content(
    template = template.toDomain(),
    title = title,
    url = url
)

private fun TemplateApiEntity.toDomain() = Template(card, direction, `object`, size)