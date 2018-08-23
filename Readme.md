Работа с Docker на Windows
---
### Создание образа(image)
Переходим в папку с проектом, где находится app.py и Dockerfile. Вполняем следущую команду, которая создаёт образ:
```python
docker build -t csai .
```
### Создание контейнера(container)
```python
docker run -d -p 8080:8080 csai
```
Пробрасываем порты: \[порт на pc\]:\[порт в контейнере\]
